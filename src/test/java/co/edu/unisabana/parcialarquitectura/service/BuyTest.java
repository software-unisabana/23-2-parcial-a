package co.edu.unisabana.parcialarquitectura.service;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Profile;
@Profile("test")
class BuyTest {
  private final Buy service = new Buy();

  @Test
  public void test() {
    service.makePurchase(2, 3, "Books");
  }

}