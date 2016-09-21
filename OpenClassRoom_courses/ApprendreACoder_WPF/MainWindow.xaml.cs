using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Threading;

namespace ApprendreACoder_WPF
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        int secretNumber = new Random().Next(1,20);
        int compteur = 0;

        public MainWindow()
        {
            InitializeComponent();
        }

        private void btnRecommencer_Click(object sender, RoutedEventArgs e)
        {
            compteur = 0;
            nmbEssaie.Text = "Nombre d'essaie : 0";
            textBoxInfo.Text = "";
            numberInputBox.Text = "";
            secretNumber = new Random().Next(1, 20);
        }

        private void btnValider_Click(object sender, RoutedEventArgs e)
        {
            chiffreEgal(ref secretNumber);

            setCounter();
        }

        void setCounter()
        {
            string[] tempNmbEssaie = nmbEssaie.Text.Split(':');
            nmbEssaie.Text = tempNmbEssaie[0];
            nmbEssaie.Text += ": "+(++compteur).ToString();
        }

        void chiffreEgal(ref int secretNumber)
        {

            textBoxInfo.Text = "\tEntrer un chiffre entre 1 et 20: ";

            string number = numberInputBox.Text;

            if (checkNumberIsAInt(ref number))
            {
                checkBigOrSmall(ref number);
            }
        }

        bool checkNumberIsAInt(ref string number)
        {
            int numberInput = 0;

            if (!int.TryParse(number, out numberInput))
            {
                textBoxInfo.Text = "Pas un chiffre.\tVeuillez recommencer";
                return false;
            }
            else
            {
                textBoxInfo.Text = "";
                return true;
            }
                
        }

        void checkBigOrSmall(ref string number)
        {
            if (number.Equals(secretNumber.ToString()))
            {
                textBoxInfo.Text = "Bravo!";
            }
            else
            {
                if (int.Parse(number) > secretNumber)
                {
                    textBoxInfo.Text = "Trop grand.";
                }

                else
                {
                    textBoxInfo.Text = "Trop petit.";
                }
            }
        }
    }
}
