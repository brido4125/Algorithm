#include <stdlib.h>

int main() {
    int H, W, N, M;
    scanf("%d %d %d %d", &H, &W, &N, &M);
    printf("%d", (H/++N+(H%N>0))*(W/++M+(W%M>0)));
}
