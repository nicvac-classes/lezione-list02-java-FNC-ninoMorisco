import java.util.NoSuchElementException;

public class Lista<T> {

    Nodo<T> head;
    
    public Lista<T>(Nodo<T> head) {
        head = null;
    }

    public boolean vuota() {
        if (head.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void aggiungiInTesta(T dato) {
        Nodo<T> nuovoNodo = new Nodo(dato);
        nuovoNodo.next = head;
        head = nuovoNodo;
    }

    public void aggiungiInCoda(T dato) {
        Nodo <T> nuovoNodo = new Nodo(dato);

        if (head == null) {
            head = nuovoNodo;
        }

        Nodo<T> curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = nuovoNodo;
    }

    public void aggiungiInPosizione(T dato, int posizione) {
        if (posizione==0) {
            this.aggiungiInTesta(dato);
        } else {
            Nodo<T> curr = head;
            currI = 0;
            while (currI<posizione-1 && curr.next!=null) {
                curr = curr.next;
                ++currI;
            }
            if (curr.next!=null) {
                Nodo <T> nuovoNodo = new Nodo<>(dato);
                nuovoNodo.next = curr.next;
                curr.next = nuovoNodo;
            } else {
                throw new IndexOutOfBoundsException("Posizione oltre la Lista");
            }
            
        }
        
    }

    public T leggiTesta() {
        if (head == null) {
            throw new NoSuchElementException("Lista vuota");
        }
        return head.dato;
    }

}