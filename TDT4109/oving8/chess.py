class Chess:

    def __init__(self):
        #initilize board
        self._board = []

        #fill board with empty spaces
        for i in range(8):
            self._board.append([])
            for j in range(8):
                self._board[i].append("#") # empty space
        
        #pawns
        for i in range(8):
            self._board[1][i] = "♟"
            self._board[-2][i] = "♙"
        
        #rooks
        self._board[0][0] = "♜"
        self._board[0][-1] = "♜"
        self._board[-1][0] = "♖"
        self._board[-1][-1] = "♖"

        #knights
        self._board[0][1] = "♞"
        self._board[0][-2] = "♞"
        self._board[-1][1] = "♘"
        self._board[-1][-2] = "♘"

        #bishops
        self._board[0][2] = "♝"
        self._board[0][-3] = "♝"
        self._board[-1][2] = "♗"
        self._board[-1][-3] = "♗"

        #kings and queens 
        self._board[0][3] = "♛"
        self._board[0][4] = "♚"
        self._board[-1][3] = "♕"
        self._board[-1][4] = "♔"
    
    def move(self, row, column, piece):
        return
        
    
    def __str__(self):
        s = ""

        for i in range(8):
            for j in range(8):
                s += self._board[i][j] + " "
            s += "\n"
        
        return s

def main():
    chess = Chess()
    gameOver = False
    turn = 1
    
    while not gameOver:
        print(chess)

        if (turn % 2 == 0):
            print("Black's turn")
        else:
            print("White's turn")
        
        move = input("Select a move: ")
        
    turn += 1
        

main()
