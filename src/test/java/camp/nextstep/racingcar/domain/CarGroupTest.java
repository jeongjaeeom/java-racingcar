package camp.nextstep.racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarGroupTest {

  @Test
  public void 주어진_자동차_이름으로_자동차들_생성() {
    CarGroup carGroup = new CarGroup(CarFactory.of("pobi,crong,honux"));
    assertThat(carGroup.size()).isEqualTo(3);
  }

  @Test
  public void 자동차_이름_5글자_초과_예외() {
    assertThatThrownBy(() -> CarFactory.of("pobi,crong,honux,iamfivenames"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("자동차 경주 우승자 찾기")
  void givenCars_shouldWinner() {
    Car pobi = new Car("pobi", new Position(3));
    Car crong = new Car("crong", new Position(1));
    Car honux = new Car("honux", new Position(2));
    CarGroup carGroup = new CarGroup(Arrays.asList(pobi, crong, honux));
    assertThat(carGroup.getWinners()).contains(pobi);
  }

  @Test
  @DisplayName("자동차 경주 우승자 여러명 찾기")
  void givenCars_shouldMultipleWinner() {
    Car pobi = new Car("pobi", new Position(3));
    Car crong = new Car("crong", new Position(1));
    Car honux = new Car("honux", new Position(3));
    CarGroup carGroup = new CarGroup(Arrays.asList(pobi, crong, honux));
    assertThat(carGroup.getWinners()).contains(pobi, honux);
  }

}
