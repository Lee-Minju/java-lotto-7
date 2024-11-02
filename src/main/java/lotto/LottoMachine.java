package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoMachine {
    InputView inputView = new InputView();

    public void playMachine() {
        Purchase purchase = makePurchase();
        WinningNumbers winningNumbers = makeWinningNumbers();
        BonusNumber bonusNumber = makeBonusNumber();
    }

    private Purchase makePurchase() {
        try {
            Purchase purchase = new Purchase(inputView.askPurchase());
            return purchase;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makePurchase();
        }
    }

    private WinningNumbers makeWinningNumbers() {
        try {
            List<String> dividedInput = handleWinningNumbers();
            WinningNumbers winningNumbers = new WinningNumbers(dividedInput);
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeWinningNumbers();
        }
    }

    private List<String> handleWinningNumbers() {
        String initialInput = inputView.askWinningNumbers();
        List<String> dividedInput = Arrays.asList(initialInput.split(","));
        return dividedInput;
    }

    private BonusNumber makeBonusNumber() {
        try {
            String initialInput = inputView.askBonusNumber();
            List<String> dividedInput = Arrays.asList(initialInput.split(","));
            BonusNumber bonusNumber = new BonusNumber(dividedInput);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeBonusNumber();
        }
    }
}
