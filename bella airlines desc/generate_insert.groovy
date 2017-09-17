
import java.text.SimpleDateFormat
import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 * @author István
 */
class generate extends Specification {
	
    def cityId = [0..10]
    
    def "generate planes"() {
        
        setup:
            iterations + 1
            Random random = new Random()
            StringBuilder builder = new StringBuilder("INSERT INTO `bella_airline`.`planes`\n\
    (`max_speed`,`number_of_staff`,`number_of_passanger`,`max_cargo_weight`,`plane_weight`)VALUES(")
            builder.append((random.nextInt(1000-300+1)+300)+",")
            builder.append((random.nextInt(10-4+1)+4)+",")
            builder.append((random.nextInt(200-40+1)+40)+",")
            builder.append((random.nextInt(4000-1000+1)+1000)+",")
            builder.append((random.nextInt(10000-3000+1)+3000)+");")
        when:
            println builder.toString() 
        then:
            builder.toString() != null
        where:
            //iterations << 1..40
            iterations << [1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10]
    }
    
    def "generate passangers"() {
        
        setup:
            iterations + 1
            Random random = new Random()
            StringBuilder builder = new StringBuilder("INSERT INTO `bella_airline`.`passangers`(`first_name`,`last_name`)VALUES(")
            builder.append("\'"+fist_names[random.nextInt(fist_names.size()-1)]+"\',")
            builder.append("\'"+last_names[random.nextInt(last_names.size()-1)]+"\');")
        when:
            println builder.toString() 
        then:
            builder.toString() != null
            
        where:
            last_names = ['Bull', 'Rambo', 'Connor', 'Tailor', 'Wolf', 'Smith', 'Brown', 'Moore', \
    'Anderson', 'Martinez', 'Scott', 'Hall', 'Young', 'Robinson','Martin', 'James', 'Ward', 'Foster']
            fist_names = ['Abel', 'John', 'Sarah', 'Evelyn', 'Diana', 'Brett', 'David', 'Dave', 'Andrew', \
    'Paula', 'Lisa', 'Vanessa', 'Ken', 'William', 'George', 'Donald', 'Philip', 'Frank', 'Betty', 'Anne', 'Jessica']
        
            iterations << [1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,
            1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,
        1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10]
    }
    
    def "generate flishts"() {
        
        setup:
            iterations + 1
            Random random = new Random()
            StringBuilder builder = new StringBuilder("INSERT INTO `bella_airline`.`flights`(`date_of_departure`,`date_of_arrival`,`departure_airport_id`,`arrival_airport_id`,`plane_id`)\n\
    VALUES(")
            Date randDate = getRandDate()
            
            builder.append("\'"+formatter.format(randDate).toString()+"\',")
            randDate = randDate + (random.nextInt(28)+1)
            builder.append("\'"+formatter.format(randDate).toString()+"\',")
            builder.append((random.nextInt(10)+1)+",")
            builder.append((random.nextInt(10)+1)+",")
            builder.append((random.nextInt(40)+1)+");")
        when:
            println builder.toString() 
        then:
            builder.toString() != null
        where:
            formatter = new SimpleDateFormat("yyyy.MM.dd")
            iterations << [1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,
            1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10] 
    }

    private Date getRandDate() {
        Date curdate = new Date()
        Date randomdate = curdate + new Random().nextInt(365)
        return randomdate
    }
    
    def "generate passanger_to_flight"() {
        
        setup:
            iterations + 1
            Random random = new Random()
            StringBuilder builder = new StringBuilder("INSERT INTO `bella_airline`.`passanger_to_flight`(`flight_id`,`passanger_id`)VALUES(")
            builder.append((random.nextInt(60)+1)+",")
            builder.append((random.nextInt(120)+1)+");")
        when:
            println builder.toString() 
        then:
            builder.toString() != null
        
        where:
            formatter = new SimpleDateFormat("yyyy.MM.dd")
            iterations << [1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,
            1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,
            1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,
            1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,
            1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,
            1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,
            1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10] 
    }
}

