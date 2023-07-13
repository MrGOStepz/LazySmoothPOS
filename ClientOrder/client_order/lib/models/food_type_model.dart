enum FoodType {
  main('Main'),
  setMenu('Set Menu'),
  beverage('Beverage'),
  dessert('Dessert'),
  rice('Rice'),
  meal('Meal');

  const FoodType(this.value);

  final String value;
}
//Example in Enum
// extension FoodTypeExcension on FoodType {
//   String? get name {
//     switch (this) {
//       case FoodType.beverage:
//         return 'Beverage';
//       default:
//         return null;
//     }
//   }
// }