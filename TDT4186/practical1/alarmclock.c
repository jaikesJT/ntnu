#include <stdio.h>
#include <time.h>
#include <string.h>

//function to find current time with appropriate format
const char* currentTime() {
    time_t mytime = time(NULL);
    char * time_str = ctime(&mytime);
    time_str[strlen(time_str)-1] = '\0';

    return time_str;
}

//main function, to create interface in shell 
int main() {
    printf("Welcome to the alarm clock! It is currently %s\n", currentTime());
    
    char command; //input character (user command)

    printf("Please enter 's' (schedule), 'l' (list), 'c' (cancel), 'x' (exit)\n");
    scanf("%c", &command);

    while (command != 'x') {
        if (command == 's') {
            printf("Schedule alarm at which date and time?\n ");

        } else if (command == 'l') {
            printf("You chose 'l'\n");

        } else if (command == 'c') {
            int alarmNr;
            printf("Cancel which alarm? ");
            scanf("%d", &alarmNr);
            printf("Alarm nr that is to be cancelled is: %d\n", alarmNr);
        }

        printf("Please enter 's' (schedule), 'l' (list), 'c' (cancel), 'x' (exit)\n");
        scanf(" %c", &command);
    }

    printf("Goodbye!\n");

    return 0;
}