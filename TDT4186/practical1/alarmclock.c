#include <stdio.h>
#include <time.h>
#include <string.h>

//function to find time with appropriate format
const char* time_str() {
    time_t mytime = time(NULL);
    char * time_str = ctime(&mytime);
    time_str[strlen(time_str)-1] = '\0';

    return time_str;
}

//main function, to create interface in shell 
int main() {
    printf("Welcome to the alarm clock! It is currently %s\n", time_str());
    
    return 0;
}