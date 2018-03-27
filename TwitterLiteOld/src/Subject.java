public interface Subject {
    public abstract void notifyObservers();
    public abstract void registerObserver(Observer observer);
    public abstract void removeObserver(Observer observer);
}
