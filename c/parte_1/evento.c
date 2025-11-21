#include <stdio.h>
#include <stdlib.h>

int converter_para_minutos(int hh, int mm)
{
    return (60 * hh) + mm;
}

void converter_para_hhmm(int minutos, int *hh, int *mm)
{
    *hh = minutos / 60;
    *mm = minutos % 60;
}

void duracao_evento(int hh_i, int mm_i, int hh_f, int mm_f, int *hh_d, int *mm_d)
{
    int dia = converter_para_minutos(24, 0);
    int i = converter_para_minutos(hh_i, mm_i);
    int f = converter_para_minutos(hh_f, mm_f);
    int d = (f > i) ? f - i : dia - i + f;
    converter_para_hhmm(d, hh_d, mm_d);
}

int main()
{
    int hh_i, mm_i, hh_f, mm_f, hh_d = 0, mm_d = 0;
    printf("Entre com o horário de início (HH:MM): ");
    scanf("%d:%d", &hh_i, &mm_i);
    printf("Entre com o horário de término (HH:MM): ");
    scanf("%d:%d", &hh_f, &mm_f);
    duracao_evento(hh_i, mm_i, hh_f, mm_f, &hh_d, &mm_d);
    printf("Duração do evento: %02d:%02d\n", hh_d, mm_d);
    return EXIT_SUCCESS;
}