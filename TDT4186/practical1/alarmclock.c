#include <stdio.h>
#include <time.h>
#include <string.h>

int main() {
    //finding current time in nice format
    time_t mytime = time(NULL);
    char * time_str = ctime(&mytime);
    time_str[strlen(time_str)-1] = '\0';

    printf("Welcome to the alarm clock! It is currently %s\n", time_str);
    return 0;
}