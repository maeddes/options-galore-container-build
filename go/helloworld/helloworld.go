package main
import "fmt"

func variables() {

    var a = "matthias"
    fmt.Println(a)

    var b, c int = 3, 4
    fmt.Println(b, c)

    var d = true
    fmt.Println(d)

    var e int
    fmt.Println(e)

    f := "String"
    fmt.Println(f)
}


func helloworld() {
    fmt.Println("hello world")
	fmt.Println(true)
	fmt.Println(2+2)
	fmt.Println("3 * 3 = ",3*3)
}

func multiply(a,b int) int{

	return a*b
}

func loops(){

	i := 0;
	for i < 10 {

		fmt.Println(i, i, " * ",i, " = ", multiply(i,i))
		i++;

	}

	for j:=0; j <= 10; j++ {

		fmt.Println(j, j, " + ",j, " = ", j+j)
	}
}


func main(){

	fmt.Println(" === Basics:")
	helloworld()
	fmt.Println(" === Variables")
	variables()
	fmt.Println(" === Loops")
	loops()

}



