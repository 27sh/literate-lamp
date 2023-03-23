using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Project07_14
{
    internal class Program
    {
        static void Main(string[] args)
        {
            char[] s = new char[5];
            int top = 0;

            s[top] = '1';
            Console.WriteLine("PUSH : {0}", s[top]);
            top++;

            s[top] = '2';
            Console.WriteLine("PUSH : {0}", s[top]);
            top++;

            s[top] = '3';
            Console.WriteLine("PUSH : {0}", s[top]);
            top++;

            Console.WriteLine();

            Console.Write("List : ");

            foreach (char list in s)
            {
                Console.Write(list+ " ");
            }

            Console.WriteLine();
            Console.WriteLine();

            top--;
            Console.WriteLine("POP : {0}", s[top]);
            s[top] = ' ';

            top--;
            Console.WriteLine("POP : {0}", s[top]);
            s[top] = ' ';

            Console.WriteLine();

            Console.Write("List : ");

            foreach (char list in s)
            {
                Console.Write(list + " ");
            }

            Console.WriteLine();
        }
    }
}
