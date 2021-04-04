package ee.helmes.common;

import lombok.Data;

import java.util.List;

@Data
public class UserDataRequest {
    private Long id;
    private String name;
    private List<Integer> sectors;
    private boolean termsAgreement;
}
