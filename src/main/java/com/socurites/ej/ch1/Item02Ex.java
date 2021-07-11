package com.socurites.ej.ch1;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;
import static com.socurites.ej.ch1.NyPizza.Size.*;
import static com.socurites.ej.ch1.Pizza.Topping.*;

/**
 * 생성자에 매개변수가 많다면 빌더를 고려하라
 */
public class Item02Ex {
  public static void main(String[] args) {
    NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
      .calories(100)
      .sodium(3)
      .carbohydrate(27)
      .build();

    Pizza nyPizza = new NyPizza.Builder(SMALL)
      .addTopping(SAUSAGE)
      .addTopping(ONION)
      .build();

    Pizza calzone = new Calzone.Builder()
      .addTopping(HAM)
      .sauceInside()
      .build();
  }
}

class NutritionFacts {
  private final int servingSize;
  private final int servings;
  private final int calories;
  private final int fat;
  private final int sodium;
  private final int carbohydrate;

  private NutritionFacts(Builder builder) {
    servingSize = builder.servingSize;
    servings = builder.servings;
    calories = builder.calories;
    fat = builder.fat;
    sodium = builder.sodium;
    carbohydrate = builder.carbohydrate;
  }

  public static class Builder {
    // required
    private final int servingSize;
    private final int servings;

    // optional
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbohydrate = 0;

    public Builder(int servingSize, int servings) {
      this.servingSize = servingSize;
      this.servings = servings;
    }

    public Builder calories(int val) {
      calories = val;
      return this;
    }

    public Builder fat(int val) {
      fat = val;
      return this;
    }

    public Builder sodium(int val) {
      sodium = val;
      return this;
    }

    public Builder carbohydrate(int val) {
      carbohydrate = val;
      return this;
    }

    public NutritionFacts build() {
      return new NutritionFacts(this);
    }
  }
}


abstract class Pizza {
  public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
  final Set<Topping> toppings;

  Pizza(Builder<?> builder) {
    toppings = builder.toppings.clone();
  }

  abstract static class Builder<T extends Builder<T>> {         // 재귀적 타입 한정 -> self type 관용구 사용
    EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

    public T addTopping(Topping topping) {
      toppings.add(Objects.requireNonNull(topping));
      return self();
    }

    abstract Pizza build();

    protected abstract T self();
  }
}

class NyPizza extends Pizza {
  public enum Size { SMALL, MEDIUM, LARGE }
  private final Size size;

  private NyPizza(Builder builder) {
    super(builder);
    size = builder.size;
  }

  public static class Builder extends Pizza.Builder<Builder> {
    private final Size size;

    public Builder(Size size) {
      this.size = Objects.requireNonNull(size);
    }

    @Override
    Pizza build() {
      return new NyPizza(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}

class Calzone extends Pizza {
  private final boolean sauceInsde;

  private Calzone(Builder builder) {
    super(builder);
    sauceInsde = builder.sauceInside;
  }

  public static class Builder extends Pizza.Builder<Builder> {
    private boolean sauceInside = false;

    public Builder sauceInside() {
      sauceInside = false;
    }


    @Override
    Pizza build() {
      return new Calzone(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}