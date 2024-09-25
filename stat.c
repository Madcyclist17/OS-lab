#include <stdio.h>
#include <sys/stat.h>
#include <time.h>

int main() {
    const char *file_path = "example.txt"; // Replace with your file path
    struct stat file_stat;

    if (stat(file_path, &file_stat) == 0) {
        printf("File Size: %ld bytes\n", file_stat.st_size);
        printf("File Permissions: %o\n", file_stat.st_mode & 0777);
        printf("Last Access Time: %s", ctime(&file_stat.st_atime));
        printf("Last Modification Time: %s", ctime(&file_stat.st_mtime));
        printf("Creation Time: %s", ctime(&file_stat.st_ctime));
    } else {
        perror("stat");
        return 1;
    }

    return 0;
}
