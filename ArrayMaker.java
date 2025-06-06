import java.util.*;
import java.util.ArrayList;

public class ArrayMaker
{
    private static ArrayList<Integer> List1;
    private static ArrayList<Integer> List2;
    private static ArrayList<Integer> Plist1;
    private static ArrayList<Integer> Plist2;
    private static int x;

    public ArrayMaker(String Row1, String Row2)
    {
        List1 = new ArrayList<>();
        List2 = new ArrayList<>();
        Plist1 = new ArrayList<>();
        Plist2 = new ArrayList<>();
        String[] parts = Row1.split(" ");

        for (String part : parts)
        {
            if (!part.isEmpty())
            {
                List1.add(Integer.parseInt(part));
            }
        }
        parts = Row2.split(" ");
        for (String part : parts)
        {
            if (!part.isEmpty())
            {
                List2.add(Integer.parseInt(part));
            }
        }
    }

    public void ArrayChange()
    {
        Plist1 = new ArrayList<>(List1);
        boolean f = false;
        int n = 0;
            for (int i = 0; i < List2.size(); i++)
            {
                f = false;
                for (int j = 0; j < Plist1.size(); j++ )
                {
                    if (Plist1.get(j) == List2.get(i))
                    {
                        f = true;
                    }
                }
                n = 0;
                if (!f)
                {
                    while ((n < Plist1.size()) && (Plist1.get(n) < List2.get(i)))
                    {
                        n++;
                    }
                    Plist1.add(n, List2.get(i));
                }
            }
        for (int k = 0; k < Plist1.size(); k++)
        {
            n = 0;
            for (int i = 0; i < List2.size(); i++)
            {
                if (Plist1.get(k).equals(List2.get(i)))
                {
                    n++;
                }
            }
            for (int j = 0; j < List1.size(); j++)
            {
                if (Plist1.get(k).equals(List1.get(j)))
                {
                    n++;
                }
            }
            Plist2.add(n);
        }
        List1 = new ArrayList<>(Plist1);
        List2 = new ArrayList<>(Plist2);
        Plist2 = new ArrayList<>();
    }


    public void print()
    {
        for (int j = 0; j < List1.size(); j++)
        {
            System.out.print(List1.get(j));
            System.out.print(" ");
        }
        System.out.println("");
        for (int i = 0; i < List2.size(); i++)
        {
            System.out.print(List2.get(i));
            System.out.print(" ");
        }
    }

    public void Repeat(int repeats)
    {
        x = repeats;
        int m = 0;
        while (m < x)
        {
            ArrayChange();
            print();
            System.out.println("");
            System.out.println("");
            m++;
        }
    }

    public static void main(String args[])
    {
        if (args.length < 3)
        {
          System.out.println("Usage: java ArrayMaker <Row1> <Row2> <Repetitions>");
          return;
        }

        String Row1 = args[0].replace("_", " ");
        String Row2 = args[1].replace("_", " ");
        int repetitions = Integer.parseInt(args[2]);

        ArrayMaker m = new ArrayMaker(Row1, Row2);
        m.print();
        System.out.println("");
        System.out.println("");
        m.Repeat(repetitions);

    }
}
