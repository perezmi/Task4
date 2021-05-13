package com.company;
import java.util.*;

public class Task4
{
    public static void main(String[] args)
    {}
    //1.Если Бесси набирает Слово, и это слово может поместиться в текущей строке,
    // поместите его в эту строку. В противном случае поместите слово на следующую
    // строку и продолжайте добавлять к этой строке. Конечно, последовательные слова
    // в одной строке все равно должны быть разделены одним пробелом. В конце любой
    // строки не должно быть места
    public static void Text(int n, int k, String str)
    {
        String pStr = "";
        int t = 0;
        int ind;
        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == ' ')
            {
                System.out.print(pStr);
                pStr = " ";
                continue;
            }

            pStr += str.charAt(i);
            t++;
            if(t % (k+1) == 0)
            {
                pStr = pStr.substring(1, pStr.length());
                System.out.println();
                t = 0;
            }
        }
        System.out.println(pStr);
    }

    //2.Напишите функцию, которая группирует строку в кластер скобок. Каждый кластер
    // должен быть сбалансирован
    public static void split(String str)
    {
        String pStr = "";
        pStr += '"';
        int i = 0, l = 0, r = 0;

        while(true)
        {
            while(str.charAt(i) == '(')
            {
                pStr += '(';
                l++;
                i++;
            }
            while(str.charAt(i) == ')')
            {
                pStr += ')';
                r++;
                i++;
                if(i == str.length())
                    break;
            }
            if(l != r)
                continue;
            l = 0;
            r = 0;
            pStr += '"';
            if(i != str.length())
                pStr += ',';

            System.out.print(pStr);
            pStr = "";
            pStr += '"';
            if(i == str.length())
                break;
        }
    }

    //3.Создайте две функции toCamelCase () и toSnakeCase (), каждая из которых берет
    // одну строку и преобразует ее либо в camelCase, либо в snake_case
    public static void toCamelCase(String str)
    {
        String pStr = "";
        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == '_')
            {
                pStr += str.substring(i+1, i+2).toUpperCase();
                i+=2;
            }
            pStr += str.charAt(i);
        }

        System.out.println(pStr);
    }

    public static void toSnakeCase(String str)
    {
        String pStr = "";
        for(int i = 0; i < str.length(); i++)
        {
            if(Character.isUpperCase(str.charAt(i)))
            {
                pStr += "_" + str.substring(i, i+1).toLowerCase();
                i++;
            }
            pStr += str.charAt(i);
        }

        System.out.println(pStr);
    }

    //4.Напишите функцию, которая вычисляет сверхурочную работу и оплату, связанную
    // с сверхурочной работой
    public static void overTime(float[] arr)
    {
        float time1 = 0, time2 = 0;
        if(arr[1] >= 17)
        {
            time1 = 17 - arr[0];
            time2 = arr[1] - 17;
        }
        else
            time1 = arr[1] - arr[0];

        System.out.println(time1 * arr[2] + time2  * arr[2] * arr[3]);
    }

    //5.Категории ИМТ таковы:
    //Недостаточный вес: <18,5
    //Нормальный вес: 18.5-24.9
    //Избыточный вес: 25 и более
    //Создайте функцию, которая будет принимать вес и рост (в килограммах, фунтах,
    // метрах или дюймах) и возвращать ИМТ и связанную с ним категорию
    public static void BMI(float weight, float height)
    {
        float BMI = weight / (height*height);
        if(BMI < 18.5)
            System.out.println(BMI + " - недостаточный вес");
        if(BMI >= 18.5 && BMI <= 25)
            System.out.println(BMI + " - нормальный вес");
        if(BMI > 25)
            System.out.println(BMI + " - избыточный вес");
    }

    //6.Создайте функцию, которая принимает число и возвращает его мультипликативное
    // постоянство, которое представляет собой количество раз, которое вы должны
    // умножать цифры в num, пока не достигнете одной цифры
    public static void bugger(int n)
    {
        int num = 0, sum = 1;
        String Num = Integer.toString(n);

        while(Num.length() > 1)
        {
            for(int i = 0; i < Num.length(); i++)
            {
                sum *= Num.charAt(i)-48;
            }
            Num = Integer.toString(sum);
            sum = 1;
            num++;
        }

        System.out.println(num);
    }

    //7.Напишите функцию, которая преобразует строку в звездную стенографию. Если символ
    // повторяется n раз, преобразуйте его в символ*n
    public static void toStarShorthand(String str)
    {
        String pStr = "";
        pStr = "";
        char sym = str.charAt(0);
        int k = 0;

        for(int i = 0; i < str.length(); i++, k++)
        {
            if(sym != str.charAt(i) || i == str.length()-1)
            {
                if(sym == str.charAt(i) && i == str.length()-1)
                    k++;
                sym = str.charAt(i);
                if(k > 1)
                    pStr += str.charAt(i-1) + "*" + k;
                else
                    pStr += str.charAt(i-1);

                k = 0;
            }
        }

        System.out.println(pStr);
    }

    //8.Создайте функцию, которая возвращает true, если две строки рифмуются, и false в
    // противном случае. Для целей этого упражнения две строки рифмуются, если последнее
    // слово из каждого предложения содержит одни и те же гласные
    public static void doesRhyme(String str1, String str2)
    {
        char[] vowel = {'a','e','i','o','u','y','A','E','I','O','U','Y'};
        List S1 = new ArrayList();
        List S2 = new ArrayList();
        for(int i = str1.length()-1; str1.charAt(i) != ' '; i--)
        {
            for (char t: vowel)
            {
                if(t == str1.charAt(i))
                {
                    S1.add(t);
                    break;
                }
            }
        }

        for(int i = str2.length()-1; str2.charAt(i) != ' '; i--)
        {
            for (char t: vowel)
            {
                if(t == str2.charAt(i))
                {
                    S2.add(t);
                    break;
                }
            }
        }
        int n = 0;
        if(S1.size() == S2.size())
            for(int i = 0; i < S2.size(); i++)
                for (var ch: S1)
                {
                    if(ch == S2.get(i))
                        n++;
                }
        else
            System.out.print("false");

        if(n == S1.size())
            System.out.print("true");
        else
            System.out.print("false");
    }

    //9.Создайте функцию, которая принимает два целых числа и возвращает true, если число
    // повторяется три раза подряд в любом месте в num1 и то же самое число повторяется
    // два раза подряд в num2
    public static void trouble(String num1, String num2)
    {
        char sym = num1.charAt(0), pSym = ' ';
        int k = 0;

        for(int i = 0; i < num1.length(); i++, k++)
        {
            if(sym != num1.charAt(i))
            {
                if (k == 3)
                    pSym = sym;
                sym = num1.charAt(i);
                k = 0;
            }
        }

        sym = num2.charAt(0);
        k = 0;
        for(int i = 0; i < num2.length(); i++, k++)
        {
            if(sym != num2.charAt(i))
            {
                if(pSym == num2.charAt(i-1) && k == 2)
                    break;
                sym = num2.charAt(i);
                k = 0;
            }
        }
        if (k == 2)
            System.out.println("true");
        else
            System.out.println("false");
    }

    //10.Предположим, что пара одинаковых символов служит концами книги для всех символов
    // между ними. Напишите функцию, которая возвращает общее количество уникальных
    // символов (книг, так сказать) между всеми парами концов книги
    public static void countUniqueBooks(String str, char sym)
    {
        int n = 0;
        List S = new ArrayList();
        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == sym)
            {
                i++;
                for(;str.charAt(i) != sym;i++)
                {
                    if(S.size() == 0)
                    {
                        S.add(str.charAt(i));
                        n++;
                    }
                    else
                        for (int j = 0; j < S.size(); j++)
                        {
                            if((char)S.get(j) == str.charAt(i))
                                break;
                            if(j == S.size()-1)
                            {
                                S.add(str.charAt(i));
                                n++;
                            }
                        }
                }
            }
        }
        System.out.println(n);
    }
}
