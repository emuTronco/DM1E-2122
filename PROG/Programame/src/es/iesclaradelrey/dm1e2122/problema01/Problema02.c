#include <stdio.h>
int main()
{
	char c;
	scanf("%c", &c);
	// printf("Inicial: %c\n", c);
	while (c != '.')
	{
		int numVerano = 0;
		int numInvierno = 0;
		while (c != '.')
		{
			if (c == 'V')
				numVerano++;
			if (c == 'I')
				numInvierno++;
			scanf("%c", &c);
			// printf("Linea: %c\n", c);
		}

		if (numVerano > numInvierno)
		{
			// printf("VERANO %i\n", numVerano);
			printf("VERANO\n");
		}
		else if (numVerano < numInvierno)
		{
			// printf("INVIERNO %i\n", numInvierno);
			printf("INVIERNO\n");
		}
		else
		{
			printf("EMPATE\n");
		}
		scanf("%c", &c); // Salto
		scanf("%c", &c);
		// printf("Final: %c\n", c);
	}
	return 0;
}
