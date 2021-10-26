.thumb
.syntax unified

.include "gpio_constants.s"     // Register-adresser og konstanter for GPIO

.text
	.global Start
	
Start:

    // Skriv din kode her...

    LDR R0, =GPIO_BASE + (PORT_SIZE * LED_PORT) //regner til register-adressen
    LDR R1, =GPIO_PORT_DOUTCLR
    ADD R1, R0, R1
    LDR R2, =GPIO_PORT_DOUTSET
    ADD R0, R0, R2

	//regner ut adressen til registeret
    LDR R2, =GPIO_BASE + (PORT_SIZE * BUTTON_PORT) + GPIO_PORT_DIN

    LDR R3, =1 << LED_PIN
    LDR R4, =1 << BUTTON_PIN

Loop:

	LDR R6, [R2]
	AND R6, R6, R4
	CMP R6, R4
	BEQ TurnOn

TurnOff:

	STR R3, [R0]
	B Loop

TurnOn:

	STR R3, [R1]
	B Loop


NOP // Behold denne pÃ¥ bunnen av fila

