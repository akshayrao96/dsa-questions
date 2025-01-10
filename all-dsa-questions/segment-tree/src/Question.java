public class Question {

  public static void main(String[] args) {
    int[] arr = new int[]{3, 7, 10, 15, 2, -6, 4, 2};
    int[] arr2 = new int[]{1, 3, 5};
    SegmentTree tree = new SegmentTreeImp(arr);
    SegmentTree tree2 = new SegmentTreeImp(arr2);

    SegmentTree tree3 = new SegmentTreeArray(arr);
    SegmentTree tree4 = new SegmentTreeArray(arr2);

    System.out.println("TREE IMPLEMENTATION");
    exampleOne(tree);
    exampleTwo(tree2);

    System.out.println("ARRAY IMPLEMENTATION");
    exampleOne(tree3);
    exampleTwo(tree4);

  }

  public static void exampleOne(SegmentTree tree) {

    System.out.println(tree.query(0, 2) + " : " + 20);
    System.out.println(tree.query(0, 1) + " : " + 10);
    System.out.println(tree.query(2, 2) + " : " + 10);
    System.out.println(tree.query(1, 2) + " : " + 17);
    System.out.println(tree.query(2, 5) + " : " + 21);
    System.out.println(tree.query(4, 5) + " : " + -4);
    System.out.println(tree.query(1, 7) + " : " + 34);
    tree.update(7, 3);
    tree.update(4, -42);
    System.out.println(tree.query(1, 7) + " : " + -9);
    System.out.println(tree.query(3, 5) + " : " + -33);
    System.out.println(tree.query(1, 3) + " : " + 32);
    tree.update(3, 0);
    System.out.println(tree.query(1, 7) + " : " + -24);

  }

  public static void exampleTwo(SegmentTree tree) {
    System.out.println(tree.query(0, 2) + " : " + 9);
    System.out.println(tree.query(0, 1) + " : " + 4); // 4
    System.out.println(tree.query(1, 2) + " : " + 8); // 8

    tree.update(1, 23);
    System.out.println(tree.query(0, 2) + " : " + 29); // 29
    System.out.println(tree.query(0, 1) + " : " + 24); // 24
    System.out.println(tree.query(1, 2) + " : " + 28); // 28

    tree.update(1, 4);
    tree.update(2, -3);

    System.out.println(tree.query(0, 1) + " : " + 5); // 5
    System.out.println(tree.query(0, 2) + " : " + 2); // 2

  }
}


/*
arr = [2, 3, 5, 2, -1, 5]

 */
