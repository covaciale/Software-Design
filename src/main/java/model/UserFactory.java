package model;

public class UserFactory {
    private DancesDAO dancesDAO = new DancesDAO();

    public User createUser(int idUser, String firstName, String secondName, int age, String gender, String dance){
        if (idUser > 0 && firstName != null && secondName != null && age > 14 &&
                (gender.equals("F") || gender.equals("M"))){
            if (dancesDAO.findByName(dance).size() != 0){
                return new User(idUser, firstName, secondName, age, gender, dance);
            }
            return null;
        }
        return null;
    }
}
