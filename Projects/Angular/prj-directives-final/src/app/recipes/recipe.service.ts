import { Recipe } from "./recipe.model";
import { EventEmitter, Injectable } from "@angular/core";
import { Ingredient } from "../shared/ingredient.model";
import { ShoppingListService } from "../shopping-list/shopping.service";

@Injectable()
export class RecipeService {
    recipeSelected = new EventEmitter<Recipe>();
    constructor(private shoppingListService: ShoppingListService) {

    }

    private recipes: Recipe[] = [
        new Recipe('Biryani',
            'Student Biryani',
            'https://cloud.lovindubai.com/images/_blogWide/Student-Biryani-4.jpg',
            [new Ingredient("Chicken", 10),
            new Ingredient("Rice", 10),
            new Ingredient("Pepper", 1),
            new Ingredient("Salt", 1)
            ]),
        new Recipe('Mutton Karahi',
            'Butt Restaurant',
            'https://kfoods.com/images1/newrecipeicon/Special-Masala-Mutton-Karahi_2118.jpg',
            [new Ingredient("Mutton", 10),
            new Ingredient("Onion", 10),
            new Ingredient("Pepper", 1),
            new Ingredient("Salt", 1)
            ])];

    getRecipes() {
        return this.recipes.slice();
    }

    addIngredientsToShoppingList(ingredients: Ingredient[]) {
        this.shoppingListService.addIngredients(ingredients);
    }
}