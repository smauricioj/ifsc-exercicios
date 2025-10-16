/*
Escreva um programa Java que simula um sistema de controle de acesso rudimentar. O sistema
deve solicitar do usuário uma senha, que é um número inteiro. Caso o usuário entre com
uma senha incorreta, o programa deve imprimir na tela a mensagem "Acesso negado (senha
incorreta)". Caso a senha esteja correta, o programa deve imprimir "Acesso autorizado".
Além disso, o usuário tem um número máximo de tentativas até que o sistema seja bloqueado;
se isso ocorrer, o programa deve imprimir "Sistema bloqueado" e encerrar imediatamente.

Utilize o comando while ou do/while.
Considere que a senha é 314159 e que o máximo número de tentativas é 3. Crie constantes
nomeadas para armazenar esses valores (final int NOME_CONSTANTE).
 */

package ifsc.alg.lista07;

import java.util.Scanner;

public class L7E2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int SENHA_CORRETA = 314159;
        final int MAX_TENTATIVAS = 3;
    }
}
