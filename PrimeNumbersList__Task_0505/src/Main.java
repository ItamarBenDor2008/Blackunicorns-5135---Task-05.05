import java.util.*;

public class Main 
{  
    public static int[] primarynumberfunction(int number) 
    {
        // בפונקציה הזאתי נשתמש ליצור רשימה של מספריים ראשונים על ידי הפרמטר שניתן לנו

        int count = 0;
        boolean trueorfalse;

        // ניצור את שתי המשתמשים האלה הראשון לספור כמה מספרים ראשונים יש והשני פרמטר שנתשמש בו ללואת פור

        int[] primarynumberlist = new int[number];

        // ניצור את הרשימה שלנו

        // לולאה ראשית: עוברת על מספרים מ-2 עד הפרמטר שקיבלנו
        for (int i = 0; i <= number; i++) 
        {   
            // דילוג על 0 ו-1 כי הם לא ראשוניים.       
            if (i == 1 || i == 0)
                continue;
            
            // ניתן ערך למשתמש הבוליאני שלנו  אשר בודק כעת אם המספר הוא ראשוני או לא
            trueorfalse = true;

            // לולאה פנימית: עוברת על המחצית הראשונה של המספר הנבדק (מספיק לבדוק חלוקה עד השורש שלו)
            for(int j = 2; j <= i / 2; ++j) 
            {
                // אם המספר מתחלק ב-גיי  אז הוא לא ראשוני וסימן שהמשתנה הבוליאני משתנה לשגוי ויוצא מהלולאה
                if(i % j == 0) 
                {
                    trueorfalse = false;
                    break;
                }
            }
            // אם המשתנה הבוליאני לא שגוי אז המספר הוא ראשוני
            if (trueorfalse == true)
            {
                // מוספים את המספר הראשוני לרשימה
                primarynumberlist[count] = i;
                // אנחנו משתמשים בקאונט כדי לדעת איפה להציב את המספר ברשימה ולדעת כמה מספריים ראשוניים יש
                count++;
            }
        }
        
        // הפונקציה מחזירה תת-רשימה של הרשימה שיצרנו בגודל של קואנט שהשתמשנו בו כדי לדעת איפה להציב ברשימה וכמה מספרים ראשונים יש
        return Arrays.copyOf(primarynumberlist, count);
    }

    public static int[] listsort(int[] list)
    {
        // בפונקציה הזאתי נסדר הרשימה מהגודל לקטן(הוספתי לכיף תהנה)
        for (int i = 0; i < list.length; i++) 
        {
            for (int j = i + 1; j < list.length; j++) 
            {
                if (list[i] < list[j]) 
                {
                    int x = list[i];
                    list[i] = list[j];
                    list[j] = x;
                }
            }
        }
        
        // נשתמש בשיטת בבאל סורט כדי לסדר את הרשימה ובסופו של דבר נחזיר את הרשימה המסודרת
        return list;
        // הרשימה שאנחנו מקבלים היא גם הפרמטר שאנחנו נשתמש גם לסדר ולהחזיר
    }
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) 
    {
        // נבקש מהמשתמש את המספר ונשתמש בו לפונקצית מציאת המספריים הראשוניים
        System.out.println("Enter your number: ");
        int number = scanner.nextInt();
        
        // ניצור שתי רשימות האחת רשימה של כל המספריים הראשוניים ונשתמש במספר שקלטנו והרשימה השנייה היא הרשימה המסודרת של הראשונה
        // נשתמש בשתי הפונקציות שיצרנו ואחרי זה נדפיס אותם

        int[] finallist = primarynumberfunction(number);
        System.out.println(Arrays.toString(finallist));

        int[] listsort = listsort(finallist);
        System.out.println(Arrays.toString(listsort));
    }
}
