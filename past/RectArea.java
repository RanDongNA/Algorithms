public class RectArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x1 = A>=E?A:E;
        int x2 = C<=G?C:G;
        int y1 = B>=F?B:F;
        int y2 = D<=H?D:H;
        System.out.println("x2: "+x2+" x1: "+x1+" y2: "+y2+" y1: "+ y1);
        if(x2<x1 || y2<y1) {
            x2=x1;
        }
        return (C-A)*(D-B)+(G-E)*(H-F)-(x2-x1)*(y2-y1);
    }
    public static void main(String[] args) {
                                                  //      A  B C D  E  F G H
        System.out.println(""+new RectArea().computeArea(-2,-2,2,2, 3, 3,4,4));
    }
}