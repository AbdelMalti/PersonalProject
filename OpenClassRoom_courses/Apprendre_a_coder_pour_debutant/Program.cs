using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Apprendre_a_coder_pour_debutant
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Jeux du plus ou moins");

            Random rand = new Random();
            int secretNumber = rand.Next(1, 20);

            while (! chiffreEgal(ref secretNumber)) ;

            Console.ReadKey();

        }

        static bool chiffreEgal(ref int secretNumber)
        {

           Console.Write("\tEntrer un chiffre entre 1 et 20: ");
           string number = Console.ReadLine();

           checkNumber(ref number);

            if (number.Equals(secretNumber.ToString()))
            {
                Console.WriteLine("Vous avez reussi!");
                return true;
            }
            else
            {
                if (int.Parse(number) > secretNumber)
                {
                    Console.WriteLine("Le chiffre que vous avez entrer est trop grand.");
                }

                else
                {
                    Console.WriteLine("Le chiffre que vous avez entrer est trop petit.");
                }

                return false;
            }
        }

        static void checkNumber(ref string number)
        {
            int numberInput = 0;

            while (! int.TryParse(number, out numberInput))
            {
                Console.Write("Vous n'avez pas entrer un chiffre.\nVeuillez recommencer : ");
                number = Console.ReadLine();
            }
        }
    }
}
