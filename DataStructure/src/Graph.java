import java.beans.VetoableChangeListener;

public class Graph<T extends Comparable> {
    private Vertex<T> head;

    public Vertex<T> findVertex(String id){
        Vertex<T> iterator=head;
        while(iterator!=null){
            if(iterator.id.compareTo(id)==0){
                return iterator;
            }
            iterator=iterator.nextVertex;
        }
        return null;
    }

    public int inDegree(String id){ return 0; }

    public int outDegree(String id) {
    return 0;
    }

    public void display() {
        Vertex<T> iterator = head;
        if (head == null) System.out.println("graph is empty.");
        else {
            while (iterator.nextVertex!=null) {
                while (iterator.EdgeLink != null) {
                    System.out.println(iterator.id + "-" + iterator.EdgeLink.vertexId);
                    iterator.EdgeLink = iterator.EdgeLink.nextEdge;
                }
                iterator = iterator.nextVertex;
            }
        }
    }



    public void addVertex(String id){
        if (findVertex(id) == null)
        {
            if (head == null)
                head = new Vertex<T>(id);
            else
            {
                Vertex<T> iterator = head;
                while (iterator.nextVertex != null)
                    iterator = iterator.nextVertex;
                iterator.nextVertex = new Vertex<T>(id);
            }
        }
        else
        {
            System.out.println("this vertex exists");
        }
    }

    public void addEdge(String idStart, String idEnd, int weight){
        Vertex<T> current = findVertex(idStart);
        if (current != null && findVertex(idEnd) != null)
        {
            Edge iterator = current.EdgeLink;
            if (iterator == null)
                current.EdgeLink = new Edge(idEnd, weight);
            else
            {
                while (iterator.nextEdge != null)
                    iterator = iterator.nextEdge;
                iterator.nextEdge = new Edge(idEnd, weight);
            }
        }else
            System.out.println("this edge can not exist");
    }


    public void findNeighbors(String id){
        Vertex<T> current=findVertex(id);
        if(current==null){
            System.out.println("there is no vertex with that id");
        }else{
            Edge iterator=current.EdgeLink;
            while(iterator!=null){
                System.out.println(iterator.vertexId);
                iterator=iterator.nextEdge;
            }
        }

    }

    public void display2() {
        Vertex<T> current = head;
        while (current != null) {
            System.out.print(current + ": ");
            Edge currentEdge = current.EdgeLink;
            while (currentEdge != null) {
                System.out.print(currentEdge.vertexId + "(" + currentEdge.weight + ") ");
                currentEdge = currentEdge.nextEdge;
            }
            System.out.println();
            current = current.nextVertex;
        }
    }

}