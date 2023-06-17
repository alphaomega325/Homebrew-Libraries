use std::vec::Vec;
use rand::{distributions::Uniform, Rng};

fn main() {
    let mut rng = rand::thread_rng();
    let range = Uniform::new(0,1000);
    for x in 0..100{
        println!("Beginning round {}, containing {} elements.", x, x);
        let mut vals: Vec<u64> = (0..x).map(|_| rng.sample(&range)).collect();
        insertion_sort(&mut vals);
        let mut vals2 = vals.clone();
        vals2.sort();
        assert_eq!(check_order(vals, vals2), true);
        println!("Ending round {}", x);
    }

}

fn check_order<T:Ord>(items: Vec<T>, items2: Vec<T>) -> bool{
    if items.len() != items2.len() {
        return false;
    }
    let mut position = 0;
    while position < items.len(){
        if items[position] != items2[position]{
            return false;
        }
        position += 1;
    }

    return true;
}

fn insertion_sort<T: Ord>(items: &mut Vec<T>) {
    let mut fulcrum: usize = 0;
    let mut position: usize;
    let mut lowest_number: (&T, usize);
    while fulcrum < items.len(){
        position = fulcrum + 1;
        lowest_number = (&items[fulcrum], fulcrum);
        while position < items.len(){
            if lowest_number.0 > &items[position]{
                lowest_number = (&items[position], position)
            }
            position += 1;
        }
        if fulcrum != lowest_number.1{
            swap(items, fulcrum, lowest_number.1);
        }
        fulcrum += 1;
    }
}


fn swap<T>(items: &mut Vec<T>, a: usize, b:usize){
    items.swap(a, b);
}
