package Frontend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Backend.Bee;
import Backend.Drone;
import Backend.Queen;
import Backend.Worker;
import utils.ScannerUtil;

public class TestProgram {
	
	static List<Bee>  bees;
	 
	public static void main(String[] args) {
		
		TestProgram testprogram = new TestProgram();
		
		
		System.out.println("Chào mừng bạn đến với câu chuyện con ong");
		System.out.println("----------------------------------------");
		
		Scanner scanner = new Scanner(System.in);
		int number;
		
		while(true) {
			System.out.println("Bạn hãy chọn một trong những lựa chọn sau:");
			System.out.println("1. Tạo danh sách Bee random (10 con).");
			System.out.println("2. Tấn công các con Bee.");
			System.out.println("Bạn chọn đi nào:");
			
			number = ScannerUtil.readInt(scanner, "Bạn chỉ có thể điền số thôi nhé.");
			
			switch (number) {
			case 1: {
				testprogram.CreateBees();
				break;
			}
			case 2:{
				if(bees == null) {
					System.out.println("Bạn thiết lập danh sách đã mới có thể tấn công nhé :)");
					break;
				}
				else {
					testprogram.AttackBee();
					testprogram.ShowStatus();
				}
			}
			default:
				System.out.println("Chọn 1 hoặc 2 thui nhé.");
				break;
			}
			
			
			
		}
	
		
	}

	
	private void AttackBee() {
		int dame = new Random().nextInt(81);
		for (Bee bee : bees) {
			bee.Dame(dame);
		}
		System.out.println("ATTACK SUCCESSFULLY!");
		System.out.println("-----------------------------------------");
		System.out.println();
	}
	
	private void ShowStatus() {
		int i = 1;
		for (Bee bee : bees) {
			System.out.println("\tBee " + i);
			i++;
			bee.CheckHealthStatus();
			System.out.println("-----------------------------------------");
		}
	}


	private void CreateBees() {
		bees = new ArrayList<Bee>();
		
		Random random = new Random();
		int numberWorker = random .nextInt(11);
		int numberQueen  = random.nextInt(11 - numberWorker);
		int numberDrone = 10 -  numberWorker - numberQueen;
		
		for (int i = 0; i < numberWorker; i++) {
			Worker worker = new Worker();
			bees.add(worker);
		}
		for (int j = 0; j < numberQueen; j++) {
			Queen queen = new Queen();
			bees.add(queen);
		}
		for (int k = 0; k < numberDrone; k++) {
			Drone drone = new Drone();
			bees.add(drone);
		}
		
		 Collections.shuffle(bees);
		 
		 System.out.println("Create success.!!");
		
	}	
	
}	
