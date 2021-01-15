package com.example.operationsUt;

import com.example.developmenttask.DevelopmentTaskApplication;
import com.example.directory.DessertRepository;
import com.example.dm.DessertCreationDTO;
import com.example.entity.Dessert;
import com.example.operations.DessertServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest(classes= {DevelopmentTaskApplication.class})
public class OperationsUt {
    @MockBean
    private DessertRepository dessertRepository;

    @InjectMocks
    private DessertServiceImpl dessertService;

    private String name = "French Macaron";
    private String description = "These French macarons make a very special treat to give your friends and family. " +
                "They also look pretty on a plate for guests to indulge in when they come over. " +
                "They can definitely be finicky but once you learn how to make macarons you’ll be hooked!";
    private String ingredient = "eggs, vanilla extract, salt, butter, cream of tartar, granulated sugar, powdered suger, " +
                "almond flour";
    private String steps = "1. Sieve the icing sugar and the ground almonds together in a large bowl and whisk together.\n" +
                "\n" +
                "2. Whiz the dry ingredients in the food processor and then sieve again. Repeat this process two more times." +
                " Seems like a lot but this is how you get a nice smooth top.\n" +
                "\n" +
                "3. Whip the egg whites with the cream or tartar. Add salt and gradually add the sugar. " +
                "Mix until the merengue reaches the soft peak stage. Add vanilla and any gel food coloring in at this point.\n" +
                "\n" +
                "4. The meringue needs to be whipped to STIFF peaks so it’s actually best to finish the whisking off by hand. " +
                "This way you’ll have a better feel for then the meringue is done.\n" +
                "\n" +
                "5. Add a third of the confectioner’s sugar and almond mixture and fold in gently. " +
                "Move the spatula in circular motions bringing material from underneath to the top. " +
                "Add the remaining dry mixture and continue folding. See the section on macaronage below for some more details.\n" +
                "\n" +
                "6. You’ll know it’s ready when it has a “lava-like” consistency, " +
                "forming a thick ribbon that slowly blends back into itself when drizzled from your spatula. " +
                "A figure “8” test will tell you when the consistency is correct. " +
                "The batter should drizzle off the spatula and form an eight. Stop immediately at this point.\n" +
                "\n" +
                "7. Transfer batter to a piping bag fitted with a round tip, " +
                "I usually use a 12 tip. Pipe onto a sheet of parchment paper fixed to a baking sheet. " +
                "You can use some batter as glue to hold the sheet steady. " +
                "Pipe perpendicular to the surface and try to be consistent with the sizes. " +
                "You can print a guide out and have it below the parchment paper to help you pipe uniform circles. " +
                "When you are finishing the piping motion stop squeezing the bag and pull up with a circular motion.\n" +
                "\n" +
                "8. Tap the tray several times to remove air bubbles. Allow to sit for 40-60 minutes so the macarons form a skin. " +
                "You should be able to touch the shell and feel a dry surface. Heat oven to 300F. Bake for 12-15 minutes. " +
                "You’ll know they’re done when if the shells don’t wobble when you move them, " +
                "you may need to give them a bit more time in the oven if they are not done. " +
                "Allow to cool for about 10 minutes on the pan then transfer to a rack to cool completely. " +
                "Pipe your filling onto the back of half the shells. Form a sandwich and enjoy!";

    @Test
    public void testRead() {
        DessertCreationDTO dessertCreationDTO = new DessertCreationDTO();
        dessertCreationDTO.setName(name);
        dessertCreationDTO.setDescription(description);
        dessertCreationDTO.setIngredient(ingredient);
        dessertCreationDTO.setSteps(steps);
        Dessert dessert = (new DessertServiceImpl()).createDessertRx(dessertCreationDTO);

        int samplesInCollection = dessertRepository.findAll().size();
        assertEquals("Only 1 sample should exist collection, but there are " + samplesInCollection, 1, samplesInCollection);

        boolean checker = dessertRepository.findById(dessert.getId()).isPresent();
        assertEquals("Read Operation Not Working",true, checker);
    }

}
