package perimeter;

import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
	
    public double getPerimeter (Shape s) {
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim += currDist;
            prevPt = currPt;
        }
        return totalPerim;
    }
    
    public int getNumPoints (Shape s) {
        int count = 0;
        for (Point p : s.getPoints()) {
            count++;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        double AverageLength = getPerimeter(s) / getNumPoints(s);
        return AverageLength;
    }

    public double getLargestSide(Shape s) {
        Point prevPt = s.getLastPoint(); //prevPt <- last(x, y)
        double LargestSide = 0.0;
        double currDistance = 0.0;
        for (Point currPt : s.getPoints()) { //currPt <- (x, y)
        	currDistance = prevPt.distance(currPt);
            if (LargestSide < currDistance) {
                LargestSide = currDistance;
            }
            prevPt = currPt;
        }
        return LargestSide;
    }

//    여기서 에러 생기는게 prevPt를 currPt로 계속 변경해줘야 하는데 그게 빠져서 그런 듯
    
//    가장 큰 x좌표값 구하려면 
//    shape의 각 point를 forEach로 한 줄씩 읽고, 
//    거기서 x좌표 값 뺴내기 
//    그런 다음 최댓값을 구한다
    public double getLargestX(Shape s) {
    	double currX = 0.0;
    	double largestX = 0.0;
    	Point prevPt = s.getLastPoint();
       for (Point currPt : s.getPoints()) {
    	   currX = currPt.getX();
    	   if (largestX < currX) {
    		   largestX = currX;
    	   }
    	   prevPt = currPt;
       }
       return largestX;
    }
    
    public double getLargestPerimeterMultipleFiles() {
        double bigPerim = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerim = getPerimeter(s);
            if (bigPerim < currPerim) {
                bigPerim = currPerim;
            }
        }
        return bigPerim;
    }

    public String getFileWithLargestPerimeter() {
        double largestPerim = 0.0;
        String HasLargestPerimFilename = "";
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            String currFilename = f.getName();
            Shape s = new Shape(fr);
            double currPerim = getPerimeter(s);
            if (largestPerim < currPerim) {
                largestPerim = currPerim;
                HasLargestPerimFilename = currFilename;
            }
        }
        return HasLargestPerimFilename;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource("searching_largest_perimeter/datatest1.txt");
        Shape s = new Shape(fr);
        int pointNums = getNumPoints(s);
        double length = getPerimeter(s);
        double avgLen = getAverageLength(s);
        double longSide = getLargestSide(s);
        double bigX = getLargestX(s);
        System.out.println("Number of Points = " + pointNums);
        System.out.println("perimeter = " + length);
        System.out.println("Average length of sides = " + avgLen);
        System.out.println("Max sides = " + longSide);
        System.out.println("Big X value = " + bigX);
    }
    
    public void testPerimeterMultipleFiles() {
        double bigPerimInFiles = getLargestPerimeterMultipleFiles();
        System.out.println("The largest Perimeter of files = " + bigPerimInFiles);
    }

    public void testFileWithLargestPerimeter() {
       String filename = getFileWithLargestPerimeter();
       System.out.println("FileWithLargestPerimeter = " + filename);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.printFileNames();
        pr.testFileWithLargestPerimeter();
    }
}
