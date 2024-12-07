package ex1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.System.exit;

@SpringBootApplication
public class Lab9SpringBootJdbcMySqlApplication implements CommandLineRunner {
	@Autowired
	MasinaJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(Lab9SpringBootJdbcMySqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc=new Scanner(System.in);
		do{
			System.out.println("\nMeniul: ");
			System.out.println("0.Iesire");
			System.out.println("1.Adăugarea unei mașini în BD");
			System.out.println("2.Ștergerea unei mașini indicată prin numărul de înmatriculare");
			System.out.println("3.Căutarea unei mașini după numărul de înmatriculare");
			System.out.println("4.Extragerea unei liste care conţine toate mașinile din baza de date");
			System.out.println("5.Determinarea numărului de mașini din BD care au o anumită marcă");
			System.out.println("6.Determinarea numărului de mașini din BD care au sub 100 000 km");
			System.out.println("7.Extragera unei liste care conţine maşinile mai noi de 5 ani");
			System.out.print("Introduceti optiunea dorita: ");
			String opt=sc.nextLine();
			Logger logger= LoggerFactory.getLogger(this.getClass());
			switch(opt){
				default:
					System.out.println("Invalid option!");
					break;
				case "0":
					exit(0);
				case "1":
					System.out.println("Adauga datele masinii: ");
					System.out.print("Numarul de inmatriculare: ");
					String nr_inmatriculare=sc.nextLine();
					System.out.print("Marca: ");
					String marca=sc.nextLine();
					System.out.print("Anul fabricatiei: ");
					int an=sc.nextInt();
					sc.nextLine();
					System.out.print("Culoarea: ");
					String culoare=sc.nextLine();
					System.out.print("Numarul de kilometrii: ");
					int nr_km=sc.nextInt();
					sc.nextLine();
					System.out.println("\nAdauga masina cu nr_inmatriculare "+nr_inmatriculare+", numarul de randuri adaugate: "
							+ dao.insert(new Masina(nr_inmatriculare,marca,an,culoare,nr_km)));
					break;
				case "2":
					System.out.print("Introduceti numarul de inmatriculare al masinii sterse: ");
					String nr_inmatriculare1=sc.nextLine();
					System.out.println("\nSterge masina cu nr_inmatriculare"+nr_inmatriculare1+", numarul de randuri sterse: "
							+dao.deletebyNr_inmatriculare(nr_inmatriculare1));
					break;
				case "3":
					System.out.print("Introduceti numarul de inmatriculare al masinii cautate: ");
					String nr_inmatriculare2=sc.nextLine();
					logger.info("\nMasina cu nr_inmatriculare "+nr_inmatriculare2+"-> {}",dao.findbyNr_inmatriculare(nr_inmatriculare2));
					break;
				case "4":
					System.out.println("\nToate masinile: ");
					dao.findAll().forEach(System.out::println);
					break;
				case "5":
					System.out.print("Introduceti marca masinilor cautate: ");
					String marca1=sc.nextLine();
					logger.info("\nNumarul de " +marca1+ " este: {}",dao.nr_masini_marca(marca1));
					break;
				case "6":
					System.out.println("\nNumarul de masini sub 100k km este: "+ dao.nr_masini_sub_100k());
					break;
				case "7":
					System.out.println("\nToate masinile mai noi de 5 ani:");
					dao.masini_noi(LocalDate.now().getYear()).forEach(System.out::println);
					break;
			}
		}while(true);
	}
}
