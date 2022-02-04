#include <stdio.h>
#include <sys/types.h>

void main() {
    int pid;
    printf("In parent: pid %d PPID %d\n", getpid(), getppid());
    pid = fork();

    if (pid > 0) 
        printf("In the parent process, child PID %d\n", pid);
    else if (pid == 0)
        printf("In the child process, PID %d PPID %d\n", getpid(), getppid());
    else 
        printf("Oh, an error!\n");


}