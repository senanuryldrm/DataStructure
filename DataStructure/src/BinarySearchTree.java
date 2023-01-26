public class BinarySearchTree <T extends Comparable> {
    private TNode<T> root;

    public int findHeight() {
        return findHeight(root);
    }

    public int findHeight(TNode<T> currentRoot) {
        if (currentRoot != null) {
            int left = findHeight(currentRoot.left);
            int right = findHeight(currentRoot.right);
            return (left > right ? left + 1 : right + 1);
            //if (left > right) return left + 1;
            //return right + 1;
        }
        return 0;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clearTree() {
        this.root = null;
    }

    public int numberOfNodes() {
        return numberOfNodes(root);
    }

    public int numberOfNodes(TNode<T> tempRoot) {
        if (tempRoot == null) return 0;
        return numberOfNodes(tempRoot.left) + numberOfNodes(tempRoot.right) + 1;
    }

    public void insert(T val) {
        if (root == null) {
            root = new TNode<T>(val);
        } else {
            TNode<T> iterator = root;
            while (iterator != null) {
                if (iterator.value.compareTo(val) == 1) {
                    if (iterator.left == null) {
                        iterator.left = new TNode<>(val);
                        return;
                    } else {
                        iterator = iterator.left;
                    }
                } else{
                    if (iterator.right == null) {
                        iterator.right = new TNode<>(val);
                        return;
                    } else {
                        iterator = iterator.right;
                    }
                }
            }
        }
    }

    public void inorder(){
        inorder(root);
        System.out.println();
    }

    public void inorder(TNode<T> currentRoot){
        if(currentRoot!=null){
            inorder(currentRoot.left);
            System.out.print(currentRoot +" ");
            inorder(currentRoot.right);
        }
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    public void preorder(TNode<T> currentRoot) {
        if (currentRoot != null) {
            System.out.print(currentRoot.value + " ");
            preorder(currentRoot.left);
            preorder(currentRoot.right);
        }
    }

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    public void postorder(TNode<T> currentNode) {
        if (currentNode!=null) {
            postorder(currentNode.left);
            postorder(currentNode.right);
            System.out.print(currentNode.value + " ");
        }
    }

    public void insertRecursively(T val){
        root = insertRecursively(root,val);
    }

    public TNode<T> insertRecursively(TNode<T> currentRoot, T val){
        if(currentRoot==null){
            return new TNode<T>(val);
        }else if(currentRoot.value.compareTo(val)==1){
            currentRoot.left=insertRecursively(currentRoot.left,val);
        }else{
            currentRoot.right=insertRecursively(currentRoot.right,val);
        }
        return currentRoot;
    }

    public boolean search(T val) {
        TNode<T> iterator = root;
        while (iterator!=null) {
            if (iterator.value.compareTo(val)==0)
                return true;
            else if (iterator.value.compareTo(val)==1) {
                iterator = iterator.left;
            } else {
                iterator = iterator.right;
            }
        }
        return false;
    }

    public boolean searchRecursively(T val){
        return searchRecursively(root,val);
    }

    public boolean searchRecursively(TNode<T> currentRoot, T val){
        if(currentRoot==null){
            return false;
        }else if (currentRoot.value.compareTo(val)==0){
            return true;
        }else if(currentRoot.value.compareTo(val)==1){
            return searchRecursively(currentRoot.left,val);
        }else{
            return searchRecursively(currentRoot.right,val);
        }
    }

}

