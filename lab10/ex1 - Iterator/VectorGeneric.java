import java.util.*;

public class VectorGeneric<E> {
	private E[] vec;		
	private int nElem;	      
	private final static int ALLOC = 50;   
	private int dimVec = ALLOC;     

	@SuppressWarnings("unchecked")
	public VectorGeneric() {
		vec = (E[]) new Object[dimVec];
		nElem = 0;
	}
	
	public boolean addElem(E elem) {
		if (elem == null)
			return false;
		ensureSpace();
		vec[nElem++] = elem;
		return true;
	}

	private void ensureSpace() {
		if (nElem>=dimVec) {
			dimVec += ALLOC;
			@SuppressWarnings("unchecked")
			E[] newArray = (E[]) new Object[dimVec];
			System.arraycopy(vec, 0, newArray, 0, nElem );
			vec = newArray;
		}
	}

	public boolean removeElem(E elem) {
		for (int i = 0; i < nElem; i++) {
			if (vec[i].equals(elem)) {
				if (nElem-i-1 > 0) // not last element
					System.arraycopy(vec, i+1, vec, i, nElem-i-1 );
				vec[--nElem] = null; // libertar último objecto para o GC
				return true;
			}
		}
		return false;
	}

	public int totalElem() {
		return nElem;
	}
	
	public E getElem(int i) {
		return (E) vec[i];
	}

	public Iterator<E> Iterator() {
		return new VectorIterator<E>();
	}

	public ListIterator<E> listIterator() {
        return new VectorListIterator<>(vec, nElem);
    }

	public ListIterator<E> listIterator(int index) {
		return new VectorListIterator<>(vec, nElem, index);
	}


	public class VectorIterator<T> implements Iterator<T> {
		private int indice;

		public VectorIterator() {
			indice = 0;
		}

		public boolean hasNext() {
			return (indice < nElem);
		}

		public T next() {
			if (hasNext()) {
				@SuppressWarnings("unchecked") 
				T element = (T) VectorGeneric.this.vec[indice++];
				return element;
			}
			throw new NoSuchElementException("only " + nElem + " elements");
		}
		
		public void remove() { 
			throw new UnsupportedOperationException("Operacao nao suportada !");
		}
	}

    private class VectorListIterator<E> implements ListIterator<E> {
        private E[] vec;
        private int nElem;
        private int current = 0;

        public VectorListIterator(E[] vec, int nElem, int current) {
            this.vec = vec;
            this.nElem = nElem;
            this.current = current;
        }

        public VectorListIterator(E[] vec, int nElem) {
            this(vec, nElem, 0);
        }

        @Override
        public boolean hasNext() {
            return current < nElem;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return vec[current++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasPrevious() {
            return current > 0;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new java.util.NoSuchElementException();
            }
            return vec[--current];
        }

        @Override
        public int nextIndex() {
            return current;
        }

        @Override
        public int previousIndex() {
            return current - 1;
        }

        @Override
        public void set(E e) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException();
        }
    }


	

}
