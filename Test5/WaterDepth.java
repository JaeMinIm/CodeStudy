package Test5;

public class WaterDepth {

    // 상, 하, 좌, 우 방향 
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // 배열 내 위치가 유효한지 확인하는 메서드
    private static boolean inBounds(int[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length;
    }

    // (r, c) 위치의 값이 증가할 수 있는지 확인하는 메서드 r=행 c=열
    private static boolean canIncrease(int[][] matrix, int r, int c) {
        int currentValue = matrix[r][c];
        for (int[] dir : DIRECTIONS) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            
            // 상하좌우 위치가 유효하고 그 위치의 값이 현재 값보다 작으면 증가할 수 없음
            if (inBounds(matrix, nr, nc) && matrix[nr][nc] < currentValue) {
                return false;
            }
        }
        return true;
    }

    // 배열의 값을 증가시키는 메서드
    private static boolean increaseMatrix(int[][] matrix) {
        boolean increased = false;
        
        //새로운 배열에 기존배열 업데이트하는 메서드
        int[][] upMatrix = new int[matrix.length][matrix[0].length];

        // 현재 배열을 임시 배열로 복사
        for (int i = 0; i < matrix.length; i++) {
        	
        	//arraycopy(복사 , 첫번째, 복사할거, 첫번쨰, 길이)
            System.arraycopy(matrix[i], 0, upMatrix[i], 0, matrix[i].length);
        }

        // 조건에 따라 값 업데이트
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] > 0 && canIncrease(matrix, r, c)) {
                    upMatrix[r][c] += 1;
                    increased = true;
                }
            }
        }

        // 업데이트된 임시 배열을 원본 배열로 복사 
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(upMatrix[i], 0, matrix[i], 0, matrix[i].length);
        }
        return increased;
    }

    // 배열 출력
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    // 메인 메서드 - 예제 배열로 테스트
    public static void main(String[] args) {
        int[][] matrix = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        // 초기 배열 출력
        System.out.println("초기 배열:");
        printMatrix(matrix);

        // 배열의 값을 반복적으로 업데이트
        boolean updated;
        do {
            updated = increaseMatrix(matrix);
        }
        // 업데이트가 더 이상 일어나지 않을 때까지 반복
        while (updated);

        // 결과 배열 출력
        System.out.println("결과 배열:");
        printMatrix(matrix);
    }
}
