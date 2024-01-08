import com.peanut.datastructure.SinglyLinkedList;
import com.peanut.datastructure.SinglyLinkedListSentinel;
import org.junit.Test;

public class TestSinglylinkedList {






    @Test
    public void test1(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addFirst(4);
        singlyLinkedList.addFirst(5);
        singlyLinkedList.addFirst(6);
        singlyLinkedList.loop1(value->{
            System.out.println(value);
        });
        singlyLinkedList.loop2(value->{
            System.out.println(value);
        });
    }

    @Test
    public void test2(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);
        singlyLinkedList.addLast(5);
        singlyLinkedList.addLast(6);
        for(Integer value : singlyLinkedList){
            System.out.println(value);
        }
        System.out.println(singlyLinkedList.get(3));
        singlyLinkedList.insert(2,12);
        for(Integer value : singlyLinkedList){
            System.out.println(value);
        }
    }
    @Test
    public void test3(){
        SinglyLinkedListSentinel singlyLinkedListSentinel = new SinglyLinkedListSentinel();
    }

}
