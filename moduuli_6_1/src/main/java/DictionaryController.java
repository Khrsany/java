package dictionary;

public class DictionaryController {
    private final DictionaryView view;
    private final Dictionary model;

    public DictionaryController(DictionaryView view) {
        this.view = view;
        this.model = new Dictionary();

        // Alustetaan muutama sana (väliaikainen ratkaisu, kuten materiaalissa ehdotetaan)
        model.addWord("cat", "kissa");
        model.addWord("dog", "koira");
        model.addWord("java", "ohjelmointikieli ja kahvi");
    }

    public void onSearch(String word) {
        if (word == null || word.isBlank()) {
            view.showMessage("Anna sana ensin.");
            return;
        }

        String meaning = model.findMeaning(word);
        if (meaning == null) {
            view.showMessage("Sanaa \"" + word + "\" ei löytynyt.");
        } else {
            view.showMessage(word + " = " + meaning);
        }
    }
}
