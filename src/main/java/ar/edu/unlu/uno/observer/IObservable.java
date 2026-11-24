package ar.edu.unlu.uno.observer;

public interface IObservable {
    void agregarObservador(IObservador o);
    void removerObservador(IObservador o);
    void notificarObservadores(Object evento);
}
