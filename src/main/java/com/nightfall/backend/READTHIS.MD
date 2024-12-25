Product
@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String description;
    private BigDecimal price;
    private int stockQuantity;

Customer
 @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID customerId;

    private String name;
    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonBackReference
    private Role role;
Discount
 @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID discountId;

    @Column(unique = true, nullable = false)
    private String code;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal percentage;

    private LocalDate validFrom;
    private LocalDate validTo;


Role
@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID roleId;
    private String roleName;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<User> users;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Customer> customers;

Super_user
@Id
    private String userId;
    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

Transactions
@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String transactionId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    private Timestamp date;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

Main Functionality i want on my front end 
* Product Page <Fetch Products>
* Cart Page 
   * From Product page i will add the amount of items i want to buy e.g Screw Driver = 2 , Bolt 3, i will store the values to local storage and proceed to Checkout Page
* Checkout Page
   * On the check out page i want to add the amount of money / payment im going to do and also display the total amount of money i need to spend
This are the functionality i want to be able to do on my frontend, im expecting only two api route like 

//this is to fetch all of the products
api/v1/products
//this is to show customer transactions history
api/v1/customers/history

but i also want to add admin page that has the ability to 
* Manage Discounts CRUD
* Manage Products CRUD
* See All of the transactions

Now give me an revision artifacts to build this backend
The task would be 
- Entity Revision 
- Api Route 

if you want to go to the next task please ask to proceed first