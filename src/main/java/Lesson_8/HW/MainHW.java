package Lesson_8.HW;

// 1 Создать метод для обхода дерева в глубину, исходные данные в текстовом файле в разделе
/*
id parentId
1     0
2     0
3     1
4     3
5     4
6     0
*/
public class MainHW {
    public static void main(String[] args) {
        Tree root =
                new Tree(0,
                        new Tree(1,
                                new Tree(3,
                                        new Tree(4,
                                                new Tree(5), null), null), null),
                        new Tree(2),
                        new Tree(6));

        System.out.println("Сумма дерева = " + root.sum());
    }

    static class Tree {
        int value;
        Tree left;
        Tree center;
        Tree right;

        //узел с 3 потомками
        public Tree(int value, Tree left, Tree center, Tree right) {
            this.value = value;
            this.left = left;
            this.center = center;
            this.right = right;
        }

        //узел с 2 потомками
        public Tree(int value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        //узел без потомков
        public Tree(int value) {
            this.value = value;
        }

        public int sum() {
            int summ = value;

            if (left != null) {
                summ += left.sum();
            }

            if (center != null) {
                summ += center.sum();
            }

            if (right != null) {
                summ += right.sum();
            }
            return summ;
        }
    }
}
