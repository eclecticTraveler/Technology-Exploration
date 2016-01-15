using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SortingComparison
{
    class Program
    {
        //Code taken from exchangecore.com
        public delegate void SortMethod(int[] list);

        static void ShowSortingTimes(String methodName, SortMethod method, int[] list)
        {
            double sortTime;
            Console.WriteLine("{0} of {1} items:", methodName, list.Length);
            FillRandom(list, 10000);
            sortTime = GetSortingTime(method, list);
            Console.WriteLine("\t{0} seconds for a scrambled list", sortTime);
            sortTime = GetSortingTime(method, list);
            Console.WriteLine("\t{0} seconds for a sorted list\n", sortTime);
        }

        static double GetSortingTime(SortMethod method, int[] list)
        {
            int startTime, stopTime;
            startTime = Environment.TickCount;
            method(list);
            stopTime = Environment.TickCount;
            return (stopTime - startTime) / 1000.0;
        }


        static Random rnd = new Random();
        static void FillRandom(int[] arr, int max)
        {
            for (int i = 0; i < arr.Length; i++)
                arr[i] = rnd.Next(max + 1);
        }

        static int FindMax(int[] arr, int last)
        {
            // find the index of the largest number in the array.
            int maxIndex = 0;
            for (int i = 1; i <= last; i++)
            {
                // if the number in location i is bigger than the largest #
                // we have seen before, remember i.
                if (arr[i] > arr[maxIndex])
                    maxIndex = i;
            }
            return maxIndex;
        }

        static void swap(int[] arr, int m, int n)
        {
            int tmp = arr[m];
            arr[m] = arr[n];
            arr[n] = tmp;
        }

        static void SelectionSort(int[] list)
        {
            int last = list.Length - 1;
            do
            {
                int biggest = FindMax(list, last);
                swap(list, biggest, last);
                last--;
            } while (last > 0);
            return;
        }

        static void InsertionSort(int[] list)
        {
            for (int i = 1; i < list.Length; i++)
            {
                if (list[i] < list[i - 1])
                {
                    int temp = list[i];
                    int j;
                    for (j = i; j > 0 && list[j - 1] > temp; j--)
                        list[j] = list[j - 1];
                    list[j] = temp;
                }
            }
        }

        static void BubbleSort(int[] list)
        {
            for (int i = list.Length - 1; i > 0; i--)
            {
                for (int j = 0; j < i; j++)
                {
                    if (list[j] > list[j + 1])
                        swap(list, j, j + 1);
                }
            }

        }

        static void QuickSort(int[] a)
        {
            QuickSortRecursive(a, 0, a.Length);
        }

        static void QuickSortRecursive(int[] a, int low, int high)
        {
            if (high - low <= 1) return;
            int pivot = a[high - 1];
            int split = low;
            for (int i = low; i < high - 1; i++)
                if (a[i] < pivot)
                    swap(a, i, split++);
            swap(a, high - 1, split);
            QuickSortRecursive(a, low, split);
            QuickSortRecursive(a, split + 1, high);
            return;
        }

        static int Partition(int[] arr, int x)
        {
            int lowMark = 0, highMark = arr.Length - 1;

            while (true)
            {
                // find the first item out of place from the start
                while (lowMark < arr.Length && arr[lowMark] <= x)
                    lowMark++;
                // first the first out of place from the end
                while (highMark >= 0 && arr[highMark] > x)
                    highMark--;
                if (lowMark > highMark)
                    return highMark;
                // swap those two items
                swap(arr, lowMark, highMark);
            }
        }
        static void Main(string[] args)
        {
            int x = 20000; // list size variable
            int[] list = new int[x];
            int select; // case selection variable
            do
            {
                Console.WriteLine("Make a Selection:");
                Console.WriteLine("\t1: Insertion Sort");
                Console.WriteLine("\t2: Selection Sort");
                Console.WriteLine("\t3: Bubble Sort");
                Console.WriteLine("\t4: Quick Sort");
                Console.WriteLine("\t5: Change Array Size. Currently {0}", x);
                Console.WriteLine("\t0: Quit");
                Console.Write("Selection: "); select = int.Parse(Console.ReadLine());


                FillRandom(list, x);
                switch (select)
                {
                    case 1: ShowSortingTimes("Insertion Sort", InsertionSort, list);
                        break;

                    case 2: ShowSortingTimes("Selection Sort", SelectionSort, list);
                        break;

                    case 3: ShowSortingTimes("Bubble Sort", BubbleSort, list);
                        break;

                    case 4: ShowSortingTimes("Quick Sort", QuickSort, list);
                        break;

                    case 5:
                        do
                        {
                            Console.WriteLine("New Array Size: ");
                            x = int.Parse(Console.ReadLine());
                        } while (x < 0);
                        list = new int[x];
                        break;
                }
                Console.WriteLine();
                Console.WriteLine();
                Console.WriteLine();
            } while (select != 0);
        }
    }
}