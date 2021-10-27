.thumb
.syntax unified

.include "gpio_constants.s"     // Register-adresser og konstanter for GPIO
.include "sys-tick_constants.s" // Register-adresser og konstanter for SysTick

.text
	.global Start

Start:

	LDR R0, =SYSTICK_BASE + SYSTICK_CTRL
	LDR R1, =SysTick_CTRL_CLKSOURCE_Msk | SysTick_CTRL_TICKINT_Msk
	STR R1, [R0]

	LDR R0, =SYSTICK_BASE + SYSTICK_LOAD
	LDR R1, =FREQUENCY / 10
	STR R1, [R0]

	LDR R0, =SYSTICK_BASE + SYSTICK_VAL
	MOV R1, #0
	STR R1, [R0]

	LDR R0, =GPIO_BASE + GPIO_EXTIPSELH
	MOV R1, #0b1111 << 4
	MVN R1, R1
	LDR R2, [R0]
	AND R3, R1, R2
	LDR R4, =PORT_B << 4
	ORR R3, R3, R4
	STR R3, [R0]


	LDR R0, =GPIO_BASE + GPIO_EXTIFALL
	LDR R1, =1 << BUTTON_PIN
	LDR R2, [R0]
	ORR R2, R2, R1
	STR R2, [R0]


	LDR R0, =GPIO_BASE + GPIO_IFC
	LDR R1, =1 << BUTTON_PIN
	LDR R2, [R0]
	ORR R2, R2, R1
	STR R2, [R0]

	LDR R0, =GPIO_BASE + GPIO_IEN
	LDR R1, =1 << BUTTON_PIN
	LDR R2, [R0]
	ORR R2, R2, R1
	STR R2, [R0]

//infinite loop som kjorer i bakgrunnen
loop:
	WFI
	B loop



.global SysTick_Handler
.thumb_func
SysTick_Handler:


	LDR R0, =tenths
	LDR R1, [R0]
	ADD R1, #1
	CMP R1, #10
	BNE returnTen

Seconds:
	MOV R1, #0

	LDR R10, =GPIO_BASE + (LED_PORT * PORT_SIZE) + GPIO_PORT_DOUTTGL
	LDR R11, =1 << LED_PIN
	STR R11, [R10]


	LDR R2, =seconds
	LDR R3, [R2]
	ADD R3, #1
	CMP R3, #60
	BNE returnSec

Minutes:
	MOV R3, #0

	LDR R4, =minutes
	LDR R5, [R4]
	ADD R5, #1
	CMP R5, #100
	BNE returnMin

	MOV R5, #0
returnMin:
	STR R5, [R4]	// Minutes
returnSec:
	STR R3, [R2]	// Seconds
returnTen:
	STR R1, [R0] 	// Tenths

	BX LR


.global GPIO_ODD_IRQHandler
.thumb_func
GPIO_ODD_IRQHandler:
	LDR R0, =SYSTICK_BASE + SYSTICK_CTRL
	LDR R1, [R0]
	EOR R1, #SysTick_CTRL_ENABLE_Msk
	STR R1, [R0]

	LDR R0, =GPIO_BASE + GPIO_IFC
	LDR R1, =1 << BUTTON_PIN
	STR R1, [R0]

	BX LR


NOP // Behold denne på bunnen av fila
