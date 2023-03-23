using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace stack
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Stack<int> stack = new Stack<int>();
            stack.Push(1);
            Console.WriteLine("Push : 1");
            stack.Push(2);
            Console.WriteLine("Push : 2");
            stack.Push(3);
            Console.WriteLine("Push : 3");

            Console.WriteLine();

            Console.Write("list : ");

            foreach (var str in stack)
            {
                Console.Write("{0} ", str);
            }

            Console.WriteLine();
            Console.WriteLine();

            Console.WriteLine("POP : {0}", stack.Pop());
            Console.WriteLine("POP : {0}", stack.Pop());

            Console.WriteLine();

            Console.Write("list : ");

            foreach (var str in stack)
            {
                Console.Write("{0}", str);
            }

            Console.WriteLine();
        }
    }
}
