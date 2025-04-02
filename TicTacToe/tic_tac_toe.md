# contents
1. requirements
2. entities
3. relationships
4. method contracts

## 1. requirements
1. Player should be able to play in turns
2. Should give winner or draw if no winner is there
3. Should validate scenarios like wrong position moves, same player moves again, wrong symbol moves.

## 2. entities with relationships, method contracts
1. Player (name, PlayingPiece)
2. Board (n*n[][] piece) ---> TicTacToeBoard (3*3[][] piece) && (setCell(), isValidCell(), toString())
3. Piece (X, O, $)
4. PlayingPiece (Piece)--->PlayingPieceX, PlayingPieceY
5. TicTacToeGame (List<Player>, current player) & (startGame(), )

## 3. relationships
1. 