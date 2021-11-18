//package br.ucsal.ucsalnews.integrationTest.service;
//
//import br.ucsal.ucsalnews.entity.New;
//import br.ucsal.ucsalnews.exception.NewNotFoundException;
//import br.ucsal.ucsalnews.service.INewService;
//import builder.NewBuilder;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class NewServiceIT {
//
//    @Autowired
//    private INewService service;
//
//    @Test
//    @DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
//    public void findById_whenAnExistingIdIsCalled_shouldReturnTheNew(){
//        New newToBeSaved = NewBuilder.oneNew().build();
//
//        service.insert(newToBeSaved);
//
//        New newFound = service.findById(1l);
//        Assert.assertNotNull(newFound);
//    }
//
//    @Test
//    @DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
//    public void findById_whenAnIdNoExistsIsCalled_shouldThrowAnException(){
//        try {
//            New newFound = service.findById(1000l);
//            Assert.fail("Should throw an exception!");
//        } catch (NewNotFoundException e){
//            Assert.assertEquals("New cannot be found matching to id 1000.", e.getMessage());
//        }
//
//    }
//
//    @Test
//    @DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
//    public void save_whenAllIpuntsAreOk_shouldSaveNewInDb(){
//        New newToBeSaved = NewBuilder.oneNew().build();
//
//        service.insert(newToBeSaved);
//
//        New newFound = service.findById(1l);
//        Assert.assertNotNull(newFound);
//        Assert.assertEquals(newFound.getTitle(), newToBeSaved.getTitle());
//    }
//
//    @Test
//    @DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
//    public void save_whenNewIsNull_shouldThrowAnException(){
//        try {
//            service.insert(null);
//        } catch (Exception e){
//            Assert.assertEquals("The new to be saved cannot be null", e.getMessage());
//        }
//    }
//
//
//    @Test
//    @DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
//    public void delete_whenAnExistingNewIsBeingRemoved_shouldRemoveNewFromDatabase(){
//        New newToBeSaved = NewBuilder.oneNew().build();
//        service.insert(newToBeSaved);
//
//        service.deleteById(1l);
//
//        try {
//            New NewFound = service.findById(1l);
//            Assert.fail("Should not find the new");
//        }
//        catch (NewNotFoundException e){
//            Assert.assertEquals("New cannot be found matching to id 1.", e.getMessage());
//        }
//    }
//
//}
