#include <stdio.h>
#include <unistd.h>

int main() {
    pid_t pid = fork();  // Create a new process

    if (pid < 0) {
        perror("fork failed");
        return 1;
    }

    if (pid == 0) {
        // This block runs in the child process
        printf("I am the child process. My PID is %d and my parent's PID is %d.\n", getpid(), getppid());
    } else {
        // This block runs in the parent process
        printf("I am the parent process. My PID is %d and my child's PID is %d.\n", getpid(), pid);
    }

    return 0;
}

