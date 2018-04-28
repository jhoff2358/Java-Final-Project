

public class Cell{
    public int[] row1Intersect = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    public int[] row2Intersect = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}; 
    public int[] row3Intersect = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    public int[] col1Intersect = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    public int[] col2Intersect = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    public int[] col3Intersect = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    
    public Cell(Box[] boxes, int index){
        Box[] cellBoxes = new Box[9];
        int control = -1;
        for(int i = 0; i < boxes.length; i++){
            if(boxes[i].cellNum == index){
                control++;
                cellBoxes[control] = boxes[i];
            }
        }
        
    }
    public void intersections(Box[] cellBoxes){
        int index = 0;
        for(int i = 0; i < 9; i += 3){
            for(int j = 0; j < 9; j++){
                if(cellBoxes[i].rowPos[j] == cellBoxes[i + 1].rowPos[j] && cellBoxes[i + 1].rowPos[j] == cellBoxes[i + 2].rowPos[j] && cellBoxes[i + 2].rowPos[j] != 0){
                    int cases = i / 3 + 1;
                    switch (cases){
                        case 1: row1Intersect[j] = j + 1;
                        break;
                        case 2: row2Intersect[j] = j + 1;
                        break;
                        case 3: row3Intersect[j] = j + 1;
                        break;
                    }
                }
            }
        }
        
    }
}
