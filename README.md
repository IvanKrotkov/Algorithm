# Задание 
>Необходимо реализовать метод разворота связного списка
>(двухсвязного или односвязного на выбор).
___
# Решение 
***Реализация представлена для двусвязного списка [dMyList](dMyList.java), структура которого 
мало чем отличается от структуры, сделанной во время семинара.***
> Cам метод
>```java
> public void reverse(){
>        if(head != null && head.next != null){
>            Node node = head;
>             Node temp = head;
>             head = tail;
>             tail = temp;
>             while (node != null){
>                 temp = node.next;
>                 node.next = node.prev;
>                 node.prev = temp;
>                 node = node.prev;
>             }
>         }
>     }