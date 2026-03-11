import java.util.NoSuchElementException;

public class Lista<T> {
    private Nodo<T> head;

    public Lista() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void aggiungiInTesta(T dato) {
        Nodo<T> nuovoNodo = new Nodo<>(dato);
        nuovoNodo.next = head;
        head = nuovoNodo;
    }

    public void aggiungiInCoda(T dato) {
        Nodo<T> nuovoNodo = new Nodo<>(dato);
        
        if (head == null) {
            head = nuovoNodo;
            return;
        }
        
        Nodo<T> corrente = head;
        while (corrente.next != null) {
            corrente = corrente.next;
        }
        corrente.next = nuovoNodo;
    }

    public void aggiungiInPosizione(T dato, int posizione) {
        if (posizione < 0) {
            throw new IndexOutOfBoundsException("Posizione negativa");
        }
        
        if (posizione == 0) {
            aggiungiInTesta(dato);
            return;
        }
        
        Nodo<T> corrente = head;
        int i = 0;
        
        while (corrente != null && i < posizione - 1) {
            corrente = corrente.next;
            i++;
        }
        
        if (corrente == null) {
            throw new IndexOutOfBoundsException("Posizione oltre la fine della lista");
        }
        
        Nodo<T> nuovoNodo = new Nodo<>(dato);
        nuovoNodo.next = corrente.next;
        corrente.next = nuovoNodo;
    }

    public T leggiTesta() {
        if (head == null) {
            throw new NoSuchElementException("Lista vuota");
        }
        return head.dato;
    }

}